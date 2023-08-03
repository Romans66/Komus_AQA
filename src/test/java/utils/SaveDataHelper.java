package utils;

public class SaveDataHelper {
  private static String pwdTempVariable;
  private static String emailTempVariable;

  public static void StringTempVariableSetter(String email, String pwd) {
    pwdTempVariable = pwd;
    emailTempVariable = email;
  }

  public static String PwdTempVariableGetter() {
    return pwdTempVariable;
  }

  public static String EmailTempVariableGetter() {
    return emailTempVariable;
  }
}
