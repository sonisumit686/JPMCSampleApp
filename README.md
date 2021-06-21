# JPMCSampleApp
================================
## About
This app is to browse Albums and lets you check all Albums sorted by titles alphabetically.

## Architecture

The App uses the Architecture components, MVVM, LiveData, Room and a Repository, fetching data from the backend when there is no local data available.
Due to the nature of LiveData, the UI will be updated when the corresponding data will also change.
App also Used libraries & Components Kotlin as the main language for development of this app;
MVVM Design Pattern
Dagger HILT for dependency Injection;
View model and Live data for communication between UI Component and data layer;
Coroutines for async operations;
Constraint layout for layout creation;
Retrofit2 for network requests;
DataBinding Library for binding the View;
Navigation Architecture Component/Navigation Host,
Navigation Graph,
NavigationController;
DiffUtil,
ListAdapter & RecyclerView
Mockito,
Kotlin coroutines test,
Google truth library for assertion Junit for testing;
Single Activity Architecture

## The app has following packages:
1. **data**: It contains all the data accessing and manipulating components.
2. **di**: Dependency providing classes using DaggerHilt.
3. **ui**: View classes along with their corresponding ViewModel.
4. **utils**: Utility classes.