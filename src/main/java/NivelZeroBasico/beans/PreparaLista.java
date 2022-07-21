package NivelZeroBasico.beans;

import java.util.List;

public class PreparaLista {
    public static List<FilmesBean> items;
    String errorMessage;

	public String getErrorMessage() {
        return this.errorMessage;
    }

    public List<FilmesBean> getItems() {
        return this.items;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setItems(List<FilmesBean> items) {
        this.items = items;
    }
}
