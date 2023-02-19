package licensecontrol;

public class HardwareCheck extends Check{

    public HardwareCheck(LicenseData licensedata) {
        super(licensedata);
    }

    @Override
    public Boolean check_activation(ActivationData activation_data) {
        if (activation_data.date.after(this.licenseData.maximum_activation_date))
            return false;

        if (this.licenseData.activations.size() == this.licenseData.maximum_number_of_activations) {
            if (!this.licenseData.activations.contains(activation_data.hardware_id))
                return false;
        }

        return true;
    }
}
