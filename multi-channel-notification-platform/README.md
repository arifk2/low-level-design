# Notification Processing System

A production-style **Notification Processing System** demonstrating multiple **Gang of Four (GoF) Design Patterns** working together.

### Design Patterns Used

| Design Pattern | Participants | Purpose |
| :--- | :--- | :--- |
| **Builder** | `Notification`, `NotificationBuilder` | Constructs complex, immutable `Notification` objects step-by-step to prevent telescoping constructors. |
| **Abstract Factory** | `NotificationProviderFactory`, `IndiaNotificationFactory`, `USANotificationFactory`, `EuropeNotificationFactory`, `ProviderFactoryProducer` | Provides an interface to create families of related regional providers (SMS, Email, Push) without specifying concrete classes. |
| **Factory Method** | `createEmailSender()`, `createSmsSender()`, `createPushSender()` | Defines methods in the base factory that concrete regional factories override to instantiate specific provider implementations. |
| **Decorator** | `NotificationDecorator`, `LoggingDecorator`, `RetryDecorator`, `RateLimiterDecorator`, `EncryptionDecorator` | Dynamically attaches new responsibilities and cross-cutting concerns to a `NotificationSender` instance at runtime. |


# Project Structure

```text
notification-system
│
├── model
│   ├── Notification.java
│   ├── Priority.java
│   ├── Region.java
│   └── NotificationType.java
│
├── sender
│   ├── NotificationSender.java
│   ├── EmailSender.java
│   ├── SmsSender.java
│   └── PushSender.java
│
├── providers
│   ├── india
│   │   ├── AmazonSESEmailSender.java
│   │   ├── MSG91SmsSender.java
│   │   └── OneSignalPushSender.java
│   │
│   ├── usa
│   │   ├── SendGridEmailSender.java
│   │   ├── TwilioSmsSender.java
│   │   └── FirebasePushSender.java
│   │
│   └── europe
│       ├── MailJetEmailSender.java
│       ├── VonageSmsSender.java
│       └── AzurePushSender.java
│
├── factory
│   ├── NotificationProviderFactory.java
│   ├── IndiaNotificationFactory.java
│   ├── USANotificationFactory.java
│   ├── EuropeNotificationFactory.java
│   └── ProviderFactoryProducer.java
│
├── decorator
│   ├── NotificationDecorator.java
│   ├── LoggingDecorator.java
│   ├── RetryDecorator.java
│   ├── EncryptionDecorator.java
│   ├── RateLimiterDecorator.java
│   ├── FraudDetectionDecorator.java
│   └── MetricsDecorator.java
│
└── NotificationApplication.java
```

---

# Overall Architecture

```text
                 Client
                    │
                    ▼
         NotificationBuilder
                    │
                    ▼
              Notification
                    │
                    ▼
      ProviderFactoryProducer
                    │
                    ▼
      NotificationProviderFactory
            ▲                 ▲
            │                 │
            │                 │
      India Factory      USA Factory
            │                 │
      createEmail()     createEmail()
            │
            ▼
    AmazonSESEmailSender
            │
            ▼
   LoggingDecorator
            │
            ▼
    RetryDecorator
            │
            ▼
 RateLimiterDecorator
            │
            ▼
 EncryptionDecorator
            │
            ▼
 sendNotification()
```

---

# Builder Pattern

## Purpose

Builds immutable Notification objects using method chaining.

## Class Diagram

```text
                Notification
        ------------------------------
        title
        message
        recipient
        priority
        attachment
        cc
        bcc
        scheduledTime
        expiryTime
        ------------------------------
                ▲
                │
        NotificationBuilder
```

## Example

```java
Notification notification =
    new Notification.NotificationBuilder()
        .setTitle("Payment Successful")
        .setMessage("₹500 credited")
        .setRecipient("user@gmail.com")
        .setPriority(Priority.HIGH)
        .build();
```

---

# Abstract Factory Pattern

## Purpose

Creates an entire family of related notification providers.

## Class Diagram

```text
                     NotificationProviderFactory
                     <<Abstract Factory>>
           _______________________________________
          | createEmailSender()                  |
          | createSmsSender()                    |
          | createPushSender()                   |
          |______________________________________|
                     ▲                 ▲
                     │                 │
      IndiaNotificationFactory   USANotificationFactory
             │                          │
             │                          │
    AmazonSESEmailSender       SendGridEmailSender
    MSG91SmsSender             TwilioSmsSender
    OneSignalPushSender        FirebasePushSender
```

---

# Factory Method Pattern

Each concrete factory creates provider-specific implementations.

```java
NotificationProviderFactory factory =
        ProviderFactoryProducer.getFactory(Region.INDIA);

NotificationSender sender =
        factory.createEmailSender();
```

Returns

```text
AmazonSESEmailSender
```

---

# Decorator Pattern

## Purpose

Adds functionality dynamically without modifying existing classes.

## Class Diagram

```text
               NotificationSender
                       ▲
                       │
              AmazonSESEmailSender
                       ▲
                       │
             NotificationDecorator
      ___________________________________
      |              |                  |
      |              |                  |
 Logging      RetryDecorator     Encryption
      |              |                  |
      |______________|__________________|
                     │
              sendNotification()
```

---

# Runtime Flow

```text
NotificationBuilder
        │
        ▼
Notification
        │
        ▼
ProviderFactoryProducer
        │
        ▼
IndiaNotificationFactory
        │
        ▼
AmazonSESEmailSender
        │
        ▼
LoggingDecorator
        │
        ▼
RetryDecorator
        │
        ▼
RateLimiterDecorator
        │
        ▼
EncryptionDecorator
        │
        ▼
sendNotification()
```

---

# Sequence Diagram

```text
Client
 │
 │ Build Notification
 ▼
NotificationBuilder
 │
 ▼
Notification
 │
 │ getFactory(INDIA)
 ▼
ProviderFactoryProducer
 │
 ▼
IndiaNotificationFactory
 │
 │ createEmailSender()
 ▼
AmazonSESEmailSender
 │
 ▼
LoggingDecorator
 │
 ▼
RetryDecorator
 │
 ▼
RateLimiterDecorator
 │
 ▼
EncryptionDecorator
 │
 ▼
sendNotification()
 │
 ▼
Amazon SES API
```

---

# Client Code

```java
Notification notification =
    new Notification.NotificationBuilder()
        .setTitle("Hello Notification")
        .setMessage("Please join us")
        .setRecipient("khanrf19@gmail.com")
        .setPriority(Priority.HIGH)
        .build();

NotificationProviderFactory factory =
        ProviderFactoryProducer.getFactory(Region.INDIA);

NotificationSender sender =
        factory.createEmailSender();

sender =
    new EncryptionDecorator(
        new RateLimiterDecorator(
            new RetryDecorator(
                new LoggingDecorator(sender))));

sender.sendNotification(notification);
```

---

# Responsibilities

| Class | Responsibility |
|--------|----------------|
| Notification | Immutable notification object |
| NotificationBuilder | Builds Notification objects |
| NotificationSender | Common interface for all notification providers |
| AmazonSESEmailSender | Sends Email using Amazon SES |
| MSG91SmsSender | Sends SMS using MSG91 |
| OneSignalPushSender | Sends Push Notifications |
| NotificationProviderFactory | Abstract Factory |
| IndiaNotificationFactory | Creates India-specific providers |
| USANotificationFactory | Creates USA-specific providers |
| ProviderFactoryProducer | Returns the appropriate regional factory |
| LoggingDecorator | Logs requests and responses |
| RetryDecorator | Retries failed requests |
| RateLimiterDecorator | Prevents API abuse |
| EncryptionDecorator | Encrypts sensitive notification data |
| NotificationApplication | Client application |

---

# Execution Flow

```text
1. Build Notification (Builder Pattern)

        │
        ▼

2. Select Provider Factory (Abstract Factory)

        │
        ▼

3. Create Email Sender (Factory Method)

        │
        ▼

4. Wrap with Decorators

Logging
   │
Retry
   │
RateLimiter
   │
Encryption

        │
        ▼

5. Send Notification
```

---

# Benefits

- ✅ Loose Coupling
- ✅ Open/Closed Principle
- ✅ Easy to extend with new regions
- ✅ Easy to add new notification providers
- ✅ Runtime behavior customization
- ✅ Clean separation of responsibilities
- ✅ Production-ready architecture
- ✅ Demonstrates multiple GoF Design Patterns together

---

# Future Enhancements

- Strategy Pattern for Retry Policy
- Observer Pattern for Delivery Status
- Command Pattern for Scheduled Notifications
- Template Method for Notification Workflow
- Chain of Responsibility for Validation
- Adapter Pattern for Third-party APIs
- Proxy Pattern for Caching and Security
- Singleton Pattern for Configuration Management