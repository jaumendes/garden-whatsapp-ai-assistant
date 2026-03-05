# Garden WhatsApp AI Assistant

AI-powered WhatsApp assistant for a gardening service business.

Features:

- 24/7 automated replies
- AI-powered conversation
- service recommendation
- lead capture
- Shopify integration ready
- WhatsApp Business API ready

Tech stack:

- Java 21
- Spring Boot
- Docker
- OpenAI API
- Redis / PostgreSQL ready

Architecture:

Customer → WhatsApp → Webhook → Java Bot → AI → Reply


docker compose up


Server runs on:


http://localhost:8080


Webhook endpoint:


POST /webhook/whatsapp


Test:


curl -X POST http://localhost:8080/webhook/whatsapp

-H "Content-Type: application/json"
-d '{"from":"+351999999999","message":"Do you cut grass?"}'

## Run locally

1. clone repo
2. add OpenAI key
3. run docker compose
