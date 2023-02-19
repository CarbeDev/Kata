package licensecontrol;

public class LicenseManager {
    public static Boolean check_activation(ActivationData activation_data, LicenseData license_data) {
        /*if (license_data.type == Type.HARDWARE_NOCHECK) {
            if (activation_data.date.after(license_data.maximum_activation_date))
                return false;

            return true;
        }
        else if ((license_data.type == Type.HARDWARE_CHECK)) {
            if (activation_data.date.after(license_data.maximum_activation_date))
                return false;

            if (license_data.activations.size() == license_data.maximum_number_of_activations) {
                if (!license_data.activations.contains(activation_data.hardware_id))
                    return false;
            }

            return true;
        }

        return false;
    }*/
        try {
            return LicenceManagerFactory.create(license_data).check_activation(activation_data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
