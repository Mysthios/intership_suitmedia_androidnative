# Internship Suitmedia Android Native App
A Jetpack Compose-based Android application that checks for palindromes, displays user information, and fetches user data from an API. The app uses ViewModel with Kotlin Flow for state management and features a modern, responsive UI with three main screens.

# Features
1. First Screen: Allows users to input their name and check if a sentence is a palindrome, displaying the result in a dialog.
2. Second Screen: Shows the entered name and selected user’s name, with navigation to select a user.
3. Third Screen: Fetches and displays a list of users from the Reqres API, supporting swipe-to-refresh and infinite scrolling.
   
# State Management
Utilizes ViewModel and Kotlin Flow to manage app state, including user data and loading status.

# Features 
a custom background image, Poppins font, and Material 3 design components for a polished look.

# Dependencies
1. Jetpack Compose: For building the UI.
2. Navigation-Compose: For screen navigation.
3. Lifecycle-ViewModel-Compose: For ViewModel integration.
4. Kotlinx-Coroutines: For asynchronous operations.
5. Gson: For JSON parsing.
6. Coil-Compose: For image loading.
7. Accompanist-SwipeRefresh: For swipe-to-refresh functionality.
   
# How to Run
1. Clone the repository.
2. Ensure R.drawable.background and R.drawable.ic_photo are added to the res/drawable folder.
3. Run gradlew build to install dependencies.
4. Run the app with Android Studio or gradlew installDebug.
   
# API
Uses Reqres API to fetch user data.

# *Notes
1. Requires internet permission (INTERNET and ACCESS_NETWORK_STATE) for API calls.
2. Ensure the Poppins font files (poppins_regular.ttf and poppins_bold.ttf) are included in res/font.
3. Minimum SDK: 21, Target SDK: 34.
   
# Permissions
1. INTERNET: For API requests.
2. ACCESS_NETWORK_STATE: To check network availability.
