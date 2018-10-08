import geb.*

class GoogleSearchPage extends Page {
    static at = {
        title ==~ /.* Google Search/
    }

    static content = {
        resultTitles { $('h3') }
    }
}
