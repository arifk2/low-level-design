# Payment Processing System

## Project Structure

```text
Payment-Processing-System
│
├── model
│   ├── PaymentRequest.java
│   ├── PaymentResult.java
│   └── Transaction.java
│
├── payment
│   ├── PaymentMethod.java
│   ├── Refundable.java
│   ├── ReceiptGenerator.java
│   ├── CashbackProvider.java
│   ├── CardPayment.java
│   ├── UpiPayment.java
│   ├── WalletPayment.java
│   ├── CashPayment.java
│   └── CryptoPayment.java
│
├── cashback
│   ├── CashbackStrategy.java
│   ├── CardCashback.java
│   └── NoCashback.java
│
├── scheduler
│   └── PaymentScheduler.java
│
├── history
│   └── TransactionHistory.java
│
├── service
│   ├── PaymentProcessor.java
│   └── RetryPaymentProcessor.java
│
└── PaymentProcessingDriver.java
```

## Package Description

### 📦 model
Contains request, response, and transaction-related model classes.

- `PaymentRequest.java`
- `PaymentResult.java`
- `Transaction.java`

---

### 💳 payment
Contains payment interfaces and implementations for different payment methods.

Interfaces:
- `PaymentMethod`
- `Refundable`
- `ReceiptGenerator`
- `CashbackProvider`

Implementations:
- `CardPayment`
- `UpiPayment`
- `WalletPayment`
- `CashPayment`
- `CryptoPayment`

---

### 💰 cashback
Implements using the SOLID principle.

- `CashbackStrategy`
- `CardCashback`
- `NoCashback`

---

### ⏰ scheduler
Handles scheduled payments.

- `PaymentScheduler`

---

### 📜 history
Maintains payment transaction history.

- `TransactionHistory`

---

### ⚙️ service
Contains business logic for payment processing.

- `PaymentProcessor`
- `RetryPaymentProcessor`

---

### 🚀 Main Class

- `PaymentProcessingDriver.java`

Entry point of the application.
