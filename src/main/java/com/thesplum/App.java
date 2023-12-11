package com.thesplum;

import com.azure.communication.email.models.*;
import com.azure.communication.email.*;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.SyncPoller;

/**
 * Clase que contiene el punto de entrada de la aplicación.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0
 */
public class App {

  public static void main(String[] args) {
    final String CONNECTION_STRING = "<connection-string>";

    EmailClient emailClient = new EmailClientBuilder()
            .connectionString(CONNECTION_STRING)
            .buildClient();

    EmailAddress destination = new EmailAddress("<email-target>");

    EmailMessage message = new EmailMessage()
            .setSenderAddress("<email-domain>")
            .setToRecipients(destination)
            .setSubject("Message from Azure Email Service")
            .setBodyPlainText("Hello from server.");

    SyncPoller<EmailSendResult, EmailSendResult> poller = emailClient.beginSend(message, null);
    PollResponse<EmailSendResult> result = poller.waitForCompletion();
  }
}
