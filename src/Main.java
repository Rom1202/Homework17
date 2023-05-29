public class Main {
    private static final String VALIDATE_PATTERN = " ^[a-zA-Z0-9_] +$";
    public static void main(String[] args) {
        check("login","pass","pass");
        check("login%%%","pass","pass");
        check("login","pass%%%%","pass");
        check("loginloginloginloginloginlogin","pass","pass");
        check("login","pass","pass1234");
    }
    private static boolean  check (String login,String pass,String confirmPass){
       boolean isValid = true;
        try {
            checklogin(login);
            checkPass(pass,confirmPass);
        } catch (WrongLoginExcepition e) {
            System.out.println("Ошибка с введением логина " + e.getMessage());
            isValid = false;
        } catch (WrongPaswordExcepetion e) {
            System.out.println("Ошибка с введением паролем " + e.getMessage());
            isValid = false;
        }
        return isValid;
    }

    private static void checklogin(String login) throws WrongLoginExcepition {
        if (!login.matches(VALIDATE_PATTERN)) {
       throw new WrongLoginExcepition(" Логин должен содержать в себе только латинские буквы, цифры и знак подчеркивания. ");
        }else if (login.length() > 20) {
            throw new WrongLoginExcepition("Логин не может быть длинее 20 символов");
        }
    }
    private static void checkPass(String pass,String confirmPass) throws WrongPaswordExcepetion {
        if (!pass.matches(VALIDATE_PATTERN)){
            throw new WrongPaswordExcepetion(" Пароль должен содержать в себе только латинские буквы, цифры и знак подчеркивания. ");
        }else if (pass.length() >20 ){
            throw new WrongPaswordExcepetion("Пароль не может быть длинее 20 символов");
        }else if (!pass.equals(confirmPass)){
            throw new WrongPaswordExcepetion("Пароли не совпадают");
        }
    }
}