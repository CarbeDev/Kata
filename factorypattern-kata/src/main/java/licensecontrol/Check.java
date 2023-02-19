package licensecontrol;

public abstract class Check implements LicenseManagerInterface{

    public LicenseData licenseData;

    public Check(LicenseData licenseData){
        this.licenseData = licenseData;
    }
}
