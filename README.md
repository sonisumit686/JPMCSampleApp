# JPMCSampleApp
================================
## About
This app is to browse Albums and lets you check all Albums sorted by titles alphabetically.

## Architecture

The App uses the Architecture components, MVVM, LiveData, Room and a Repository, fetching data from the backend when there is no local data available.
Due to the nature of LiveData, the UI will be updated when the corresponding data will also change.

App also Used libraries & Components Kotlin as the main language for development of this app.
1. MVVM Design Pattern
2. Dagger HILT for dependency Injection
3. View model and Live data for communication between UI Component and data layer
4. Coroutines for async operations;
5. Constraint layout for layout creation;
6. Retrofit2 for network requests;
7. DataBinding Library for binding the View;
8. Navigation Architecture Component/Navigation Host,
9. Navigation Graph,
10. NavigationController;
11. DiffUtil,
12. ListAdapter & RecyclerView
13. Mockito,
14. Kotlin coroutines test,
15. Google truth library for assertion Junit for testing;
16. Single Activity Architecture

## The app has following packages:
1. **data**: It contains all the data accessing and manipulating components.
2. **di**: Dependency providing classes using DaggerHilt.
3. **ui**: View classes along with their corresponding ViewModel.
4. **utils**: Utility classes.