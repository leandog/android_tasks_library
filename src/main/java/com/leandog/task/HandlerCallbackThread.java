package com.leandog.task;

import android.os.Handler;

final class HandlerCallbackThread extends Thread {

    private final Handler handler;
    private final MessageProvider messageProvider;

    HandlerCallbackThread(Handler handler, MessageProvider messageProvider) {
        this.handler = handler;
        this.messageProvider = messageProvider;
    }

    @Override
    public void run() {
        handler.sendMessage(messageProvider.getMessage());
    }
}