# Api-RESTful-Nuvem

## Diagrama de Classes

```mermaid
classDiagram
    class User {
        +String name
    }

    class Account {
        +String number
        +String agency
        +String balance
        +String limit
    }

    class Feature {
        +String icons
        +String description
    }

    class Card {
        +String number
        +String limit
    }

    class News {
        +String icons
        +String description
    }

    User --> Account : has
    User --> Card : has
    User --> Feature : has many
    User --> News : has many
```