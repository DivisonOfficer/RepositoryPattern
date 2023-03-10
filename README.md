# RepositoryPattern

A demo Android project using MVVM pattern and Repository pattern implementing RxJava, Retrofit, DataBinding, and Hilt.

## Table of Contents

- [Introduction](#introduction)
- [Installation](#installation)
- [Usage](#usage)
- [Architecture](#architecture)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This is a demo Android project that showcases the implementation of the MVVM pattern and Repository pattern. The project uses RxJava, Retrofit, DataBinding, and Hilt to fetch data from a remote API and display it in the UI.

## Installation

To run this project, follow these steps:

1. Clone the repository: `git clone https://github.com/DivisonOfficer/RepositoryPattern.git`
2. Open the project in Android Studio
3. Build the project

## Usage

To use this project, follow these steps:

1. Run the app
2. The app will display a list of movies fetched from a remote API

## Architecture

```mermaid
graph LR
V((View)) -- Binds to --> VM((ViewModel))
VM -- Uses --> S((Storage))
S -- Uses --> R((Repository))
R -- Uses --> RS((Remote Source))
RS -- Communicates with --> API((API))
```

The project uses the MVVM pattern and Repository pattern. The data flow in the project is unidirectional, from the View (DataBinding) to the ViewModel to the Storage to the Repository to the RemoteSource (Retrofit). If the ViewModel needs access to a method of the Activity class, it can get that feature from the Connect class, which is a constructor property of the ViewModel. The Activity registers itself in the Connect class when `onResume` is called. Every Activity is extended by `BaseActivity`, which has the `DataBinding.setContent` implementation, launch Activity, and Activity register method for singleton classes on `onResume`. The `Storage` class, `Connect` class, and `Repository` class are singletons, while the ViewModel is an activity-retained scoped instance. The `MainActivity` extends `BaseActivity` and has the `MainViewModel` as a property. The `MainViewModel` has the `MovieStorage` and `ActivityConnect` as properties. The `MovieStorage` has the `MovieRepository` as a property, while the `MovieRepository` has the `RemoteSource` created by Retrofit as a property.


## Technologies Used

The project uses the following technologies:
<p>
    <img src="https://img.shields.io/badge/Java-1.8-blue">
    <img src="https://img.shields.io/badge/Android-SDK%2030-green">
    <img src="https://img.shields.io/badge/Hilt-2.4.4-yellow">
    <img src="https://img.shields.io/badge/RxJava-3.1.6-orange">
    <img src="https://img.shields.io/badge/Retrofit2-2.9.0-red">
  </p>

The project also uses the following libraries:

- RxJava: a reactive programming library for composing asynchronous and event-based programs.
- Retrofit: a type-safe HTTP client for Android and Java.
- DataBinding: a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
- Hilt: a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.

## Contributing

Contributions to this project are welcome. If you find a bug or want to add a new feature, please open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
