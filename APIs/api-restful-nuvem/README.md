# Api-RESTful-Nuvem

## Diagrama de Classes

```mermaid
classDiagram
    class User {
        -String name
        -Account account 
        -Feature[] features
        -Card card
        -News[] news
    }

    class Account {
        -String number
        -String agency
        -String balance
        -String limit
    }

    class Feature {
        -String icons
        -String description
    }

    class Card {
        -String number
        -String limit
    }

    class News {
        -String icons
        -String description
    }

    User *-- Account
    User *-- Card 
    User *-- Feature 
    User *-- News 
```