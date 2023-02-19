package licensecontrol;

public class LicenceManagerFactory{

public static LicenseManagerInterface create(LicenseData data) throws Exception {
    if(data.type == Type.HARDWARE_CHECK){
        return new HardwareCheck(data);
    }
    else if (data.type == Type.HARDWARE_NOCHECK){
        return new HardwareNoCheck(data);
    }
    else {
        throw new Exception("Type not found");
    }
}
}
