package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

/**
 * Created by Admin on 22.06.2017.
 */
public class ClientGuiController extends Client {
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    public static void main(String[] args){
        new ClientGuiController().run();
    }

    //  – должен создавать и возвращать объект типа GuiSocketThread.
    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    // – должен получать объект SocketThread через метод getSocketThread() и вызывать у него метод run().
    // Разберись, почему нет необходимости вызывать метод run в отдельном потоке, как мы это делали для консольного клиента.
    @Override
    public void run() {
        getSocketThread().run();
    }

    // . Они должны вызывать одноименные методы из представления (view).
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    protected int getServerPort() {
        return view.getServerPort();
    }

    protected String getUserName() {
        return view.getUserName();
    }

    public ClientGuiModel getModel(){
        return model;
    }

    /**
     *
     */
    public class GuiSocketThread extends SocketThread {
        // – должен устанавливать новое сообщение у модели и вызывать обновление вывода сообщений у представления.
        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        //  – должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения.
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        //  – должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        // – должен вызывать аналогичный метод у представления.
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }
}
