# BitPay Kiosk Demo - Java / Spring Boot

This is a demonstration Spring Boot app to show how BitPay can be used in the
context of a retail kiosk. It utilizes the the `pos` facade and with a simple 
configuration file you can customize the `posData` fields that are sent to
BitPay. This app uses Liquibase to manage the database schema and by default
uses an embedded H2 database to make it easy to start.

## Functionality

- Create invoices
- View a grid of invoices
- View invoice details
- Store invoices in a database
- Receives instant payment notifications (IPN) to update the database
- Uses EventSource to update the frontend upon receiving IPN

## Prerequisites

- BitPay Account
- Java >= 17

## Configuration

This app uses a YAML configuration file. To configure it, you'll need to either
update `application.yaml` or override specific YAML values with a custom YAML
when booting the application.

### General Information

| YAML Key                                       | Description                                                                      |
|------------------------------------------------|----------------------------------------------------------------------------------|
| app-url                                        | Sets the application URL used for IPN                                            |
| bitpay.design.hero.bgColor                     | CSS color for hero background                                                    |
| bitpay.design.hero.title                       | The title to show in the hero                                                    |
| bitpay.design.hero.body                        | The text to show under the title in the hero                                     |
| bitpay.design.logo                             | URL for the logo                                                                 |
| bitpay.design.mode                             | Determines whether the app should be run in `standard` or `donation` mode        |
| bitpay.design.donation.denominations           | Available donations to choose. The highest value determined the maximum donation |
| bitpay.design.donation.enableOther             | Determines whether the app should allow to use own donation value.               |
| bitpay.design.donation.footerText              | The text to show in the footer                                                   |
| bitpay.design.donation.buttonSelectedBgColor   | CSS color for selected donation background                                       |
| bitpay.design.donation.buttonSelectedTextColor | CSS color for selected donation text                                             |
| bitpay.design.posdata.fields                   | See the `POS Data Fields` section below                                          |
| bitpay.token                                   | Your BitPay token                                                                |
| bitpay.notificationEmail                       | The email you want to use for notifications                                      |
| server.port                                    | HTTP port to used to run the application                                         |
| spring.datasource.url                          | JDBC database URL                                                                |
| spring.datasource.username                     | The username for the database connection                                         |
| spring.datasource.password                     | The password for the database connection                                         |
| spring.datasource.hikari.maxLifetime           | The maximum lifetime of a connection in the Hikari pool                          |
| spring.jpa.hibernate.ddl-auto                  | Automatically determine how to initialize the database                           |
| spring.jpa.properties.hibernate.dialect        | Sets the dialect to use for the database                                         |
| spring.jpa.properties.hibernate.format         | Formats the database queries                                                     |
| spring.main.banner-mode                        | Enables or disables the Spring Boot banner                                       |

### POS Data Fields

#### Dropdown (posData)

| YAML Key      | Description                                            |
| ------------- | ------------------------------------------------------ |
| type          | Set to "select"                                        |
| required      | Determines whether the field should be required or not |
| id            | Field identifier                                       |
| name          | Field name                                             |
| label         | Field label                                            |
| options.id    | (options array) ID for a given selection               |
| options.label | (options array) Label for a given selection            |
| options.value | (options array) Value for a given selection            |

#### Fieldset (posData)

| YAML Key      | Description                                            |
| ------------- | ------------------------------------------------------ |
| type          | Set to "fieldset"                                      |
| required      | Determines whether the field should be required or not |
| name          | Field name                                             |
| label         | Field label                                            |
| options.id    | (options array) ID for a given selection               |
| options.label | (options array) Label for a given selection            |
| options.value | (options array) Value for a given selection            |

#### Text (posData)

| YAML Key | Description                                            |
| -------- | ------------------------------------------------------ |
| type     | Set to "text"                                          |
| required | Determines whether the field should be required or not |
| name     | Field name                                             |
| label    | Field label                                            |

#### Price

| YAML Key | Description                                            |
| -------- | ------------------------------------------------------ |
| type     | Set to "price"                                         |
| required | Determines whether the field should be required or not |
| name     | Field name                                             |
| label    | Field label                                            |
| currency | Currency for the field                                 |

## Running

Run `./gradlew clean bootRun` to run the application.

## Testing

Run `./gradlew clean test` to run tests.
