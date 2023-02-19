package licensecontrol;

public class HardwareNoCheck extends Check{

    public HardwareNoCheck(LicenseData licenseData) {
        super(licenseData);
    }

    @Override
    public Boolean check_activation(ActivationData activation_data) {
        if (activation_data.date.after(this.licenseData.maximum_activation_date))
            return false;

        return true;
    }
}
