# Repository Pattern
A demo Android project using MVVM pattern and Repository pattern implementing RxJava, Retrofit, DataBinding, and Hilt.

## Table of Contents
Introduction
Installation
Usage
Architecture
Technologies Used
Contributing
License
Introduction
This is a demo Android project that showcases the implementation of the MVVM pattern and Repository pattern. The project uses RxJava, Retrofit, DataBinding, and Hilt to fetch data from a remote API and display it in the UI.

## Installation
To run this project, follow these steps:

Clone the repository: git clone https://github.com/DivisonOfficer/RepositoryPattern.git
Open the project in Android Studio
Build the project
Usage
To use this project, follow these steps:

## Run the app
The app will display a list of movies fetched from a remote API
Architecture
The project uses the MVVM pattern and Repository pattern. The data flow in the project is unidirectional, from the View (DataBinding) to the ViewModel to the Storage to the Repository to the RemoteSource (Retrofit). If the ViewModel needs access to a method of the Activity class, it can get that feature from the Connect class, which is a constructor property of the ViewModel. The Activity registers itself in the Connect class when onResume is called. Every Activity is extended by BaseActivity, which has the DataBinding.setContent implementation, launch Activity, and Activity register method for singleton classes on onResume. The Storage class, Connect class, and Repository class are singletons, while the ViewModel is an activity-retained scoped instance. The MainActivity extends BaseActivity and has the MainViewModel as a property. The MainViewModel has the MovieStorage and ActivityConnect as properties. The MovieStorage has the MovieRepository as a property, while the MovieRepository has the RemoteSource created by Retrofit as a property.

## Technologies Used
The project uses the following technologies:

Language: Java
Framework: Android
Version: Android API 30
The project also uses the following libraries:

RxJava: a reactive programming library for composing asynchronous and event-based programs.
Retrofit: a type-safe HTTP client for Android and Java.
DataBinding: a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
Hilt: a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
Contributing
Contributions to this project are welcome. If you find a bug or want to add a new feature, please open an issue or submit a pull request.

## License
This project is licensed under the MIT License.
