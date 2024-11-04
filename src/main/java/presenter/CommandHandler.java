package presenter;

import familyTreeView.TreeView;

public class CommandHandler {
    private TreePresenter treePresenter;
    private TreeView treeView;

    public CommandHandler(TreePresenter treePresenter, TreeView treeView) {
        this.treePresenter = treePresenter;
        this.treeView = treeView;
    }

    public void handleUserInput() {
        while (true) {
            treeView.displayMessage("Enter command (1-add, 2-list, 3-sortByName, 4-sortByBirthYear, 5-save, 6-load, 7-exit):");
            String command = treeView.getUserInput();
            treePresenter.handleCommand(command);
        }
    }
}
