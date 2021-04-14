package mock;

import dados.Usuario;

public class UsuarioMock {

    public static Usuario get() {

        Usuario mockUser = new Usuario();

        mockUser.setName("Test");
        mockUser.setUser_name("TestUser");
        mockUser.setPassword("password");
        mockUser.setCredit(500.0);

        return mockUser;
    }

}
