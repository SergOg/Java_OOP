package view;

import model.Person;
import presenter.TreePresenter;

import java.util.List;

public interface TreeView extends InputView, MessageView, PersonView{
    void setPresenter(TreePresenter presenter);
}
