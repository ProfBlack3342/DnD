public final class FactoryDAOMySQL {
    private static final UsuarioDAOMySQL USUARIO_DAO = new UsuarioDAOMySQL();

    public static UsuarioDAOMySQL getUsuarioDAO() {return USUARIO_DAO;}
}
