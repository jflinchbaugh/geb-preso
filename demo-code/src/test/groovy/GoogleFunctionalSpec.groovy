import geb.spock.*
import geb.*
import spock.lang.*

class GoogleFunctionalSpec extends GebReportingSpec {
    void cleanup() {
        sleep 2000
    }

    void 'google searches'() {
        given: 'we go to google'
            to GooglePage
        when: 'we submit a search'
            form.q = 'geb spock'
            waitFor { submit().click() }
        then: 'we land at the search page'
            at GoogleSearchPage
        and: 'there are results'
            resultTitles()*.text()
        and: 'every result mentions geb'
            resultTitles()*.text().collect {
                it.contains('Geb')
            }.every()
    }
}
