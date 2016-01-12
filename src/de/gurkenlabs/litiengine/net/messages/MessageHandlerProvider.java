/***************************************************************
 * Copyright (c) 2014 - 2015 , gurkenlabs, All rights reserved *
 ***************************************************************/
package de.gurkenlabs.litiengine.net.messages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The Class MessageHandlerProvider.
 */
public class MessageHandlerProvider implements IMessageHandlerProvider {

  /** The message handlers. */
  private final HashMap<MessageType, List<IMessageHandler>> messageHandlers;

  /**
   * Instantiates a new message handler provider base.
   */
  public MessageHandlerProvider() {
    this.messageHandlers = new HashMap<>();
    this.initializeHandlers();
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * de.gurkenlabs.liti.net.messages.IMessageHandlerProvider#getMessageHander(de
   * .gurkenlabs.liti.net.messages.MessageType)
   */
  @Override
  public List<IMessageHandler> getMessageHanders(final MessageType type) {
    if (this.getMessageHandlers().containsKey(type)) {
      return this.getMessageHandlers().get(type);
    }

    return null;
  }

  @Override
  public void register(final MessageType messageType, final IMessageHandler messageHandler) {
    if (!this.getMessageHandlers().containsKey(messageType)) {
      this.getMessageHandlers().put(messageType, new ArrayList<IMessageHandler>());
    }

    if (this.getMessageHandlers().get(messageType).contains(messageHandler)) {
      return;
    }

    this.getMessageHandlers().get(messageType).add(messageHandler);
  }

  /**
   * Gets the message handlers.
   *
   * @return the message handlers
   */
  protected HashMap<MessageType, List<IMessageHandler>> getMessageHandlers() {
    return this.messageHandlers;
  }

  /**
   * Initialize handlers.
   */
  protected void initializeHandlers() {

  }
}