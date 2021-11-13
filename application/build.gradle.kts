apply {
    plugin("application")
}

plugins{
    application
}

application{
    mainClass.set("br.com.finances.product.main.Boot")
}

dependencies{
    implementation(project(":configuration"))
    implementation(project(":entities"))
    implementation(project(":input-boundary"))
    implementation(project(":output-boundary"))
    implementation(project(":repository"))
    implementation(project(":usecase"))
    implementation(project(":web"))
    implementation(project(":service"))
}