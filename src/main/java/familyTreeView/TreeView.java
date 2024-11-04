package familyTreeView;

import presenter.TreePresenter;

public interface TreeView extends InputView, MessageView, PersonView{
    void setPresenter(TreePresenter presenter);
}
