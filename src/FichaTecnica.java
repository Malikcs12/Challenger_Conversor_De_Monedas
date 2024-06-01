public class FichaTecnica {
    public String menuDeUsuario;

    public String getMenuDeUsuario() {
        return menuDeUsuario;
    }

    public void setMenuDeUsuario(String menuDeUsuario) {
        this.menuDeUsuario = menuDeUsuario;
    }

    private double numeros;

    public double getNumeros() {
        return numeros;
    }

    public void setNumeros(double numeros) {
        this.numeros = numeros;
    }

    @Override
    public String toString() {
        return "********************************************\n" +
                "Bienvenido al convertidor de monedas\n" +
                "Monedas...........................\n" +
                "Dolares........................USD\n" +
                "Peso Argentino.................Ars\n" +
                "Real Brasileño.................BRL\n" +
                "Peso Mexicano..................MXN\n" +
                "Dolar Canadiense...............CAD\n" +
                "Peso Colombiano................COP\n" +
                "********************************************\n";
    }
}
