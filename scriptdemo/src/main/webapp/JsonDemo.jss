var json = {
    engine: {
        name: String(factory.engineName),
        version: String(factory.engineVersion),
        threading: String(factory.getParameter("THREADING"))
    },
    language: {
        name: String(factory.languageName),
        version: String(factory.languageVersion)
    },
    script: {
        uri: String(request.requestURI)
    }
};

println(json.toSource().toString());