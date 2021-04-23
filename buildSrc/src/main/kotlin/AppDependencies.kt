import org.gradle.api.artifacts.dsl.DependencyHandler
object AppDependencies {
    //std lib
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    private val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private val material = "com.google.android.material:material:${Versions.material}"
    private val fragmentKTX = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    //Koin
    private val koin = "org.koin:koin-core:${Versions.koin}"
    private val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    private val koinAndroidScope = "org.koin:koin-androidx-scope:${Versions.koin}"
    private val koinAndroidViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    //Network
    private val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private val retrofitAdapter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    private val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    private val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    private val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    //Rx
    private val rxJava = "io.reactivex.rxjava3:rxjava:${Versions.rxJava}"
    private val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxJava}"
    private val rxJavaRetrofitAdapter = "com.github.akarnokd:rxjava3-retrofit-adapter:${Versions.rxJava}"

    //Navigation
    private val navigationUiKTX = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    private val navigationFragmentKTX = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"

    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    private val testCore = "androidx.test:core:${Versions.testCore}"
    private val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"

    //Koin Test
    private val testKoin = "org.koin:koin-test:${Versions.koin}"

    //coroutine
    private val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

    //ktx
    private val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ktx}"

    private val koinLibraries = arrayListOf<String>().apply {
        add(koin)
        add(koinAndroid)
        add(koinAndroidScope)
        add(koinAndroidViewModel)
    }

    private val networkLibraries = arrayListOf<String>().apply {
        add(retrofit)
        add(retrofitAdapter)
        add(retrofitGson)
        add(okhttpInterceptor)
        add(okhttp)
    }

    private val reactiveXLibraries = arrayListOf<String>().apply {
        add(rxJava)
        add(rxAndroid)
        add(rxJavaRetrofitAdapter)
    }

    private val navigationLibraries = arrayListOf<String>().apply {
        add(navigationFragmentKTX)
        add(navigationUiKTX)
    }

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
        add(appcompat)
        add(constraintLayout)
        add(material)
        add(coroutine)
        add(viewModelKtx)
        add(fragmentKTX)
        addAll(koinLibraries)
        addAll(networkLibraries)
        addAll(reactiveXLibraries)
        addAll(navigationLibraries)
    }



    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
        add(testKoin)
        add(testCore)
        add(robolectric)
    }
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}