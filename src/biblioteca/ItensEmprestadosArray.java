package biblioteca;

import java.util.ArrayList;

public class ItensEmprestadosArray extends ArrayList<ItemEmprestado> {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean remove(Object item){
		((ItemEmprestado)item).getPublicacao().maisUmLivro();
		return super.remove(item);
	}

}
