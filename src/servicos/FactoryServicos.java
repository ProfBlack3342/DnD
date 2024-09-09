public class FactoryServicos {
    private static final ServicosUsuario SERVICOS_USUARIO = new ServicosUsuario();

    public static ServicosUsuario getServicosUsuario() {return SERVICOS_USUARIO;}
}
