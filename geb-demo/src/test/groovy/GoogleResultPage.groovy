import geb.*

class GoogleResultPage extends Page {
    static at = {
        title ==~ /.* Google Search/
    }

    static content = {
        resultTitles { $('h2').parent().find('h3') }
    }
}
