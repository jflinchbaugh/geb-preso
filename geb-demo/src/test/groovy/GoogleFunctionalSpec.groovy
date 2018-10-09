import geb.spock.*
import geb.*
import spock.lang.*

class GoogleFunctionalSpec extends GebReportingSpec {
    void "search for something"() {
        given: 'go to google'
            to GooglePage
        expect: 'we see our form'
            form()
        and: 'it has a query field'
            form.q()
        and: 'a submit'
            submit
        when: 'i give it a search term'
            form.q = 'geb spock'
        and:
            submit.click()
        then:
            at GoogleResultPage
        and: 'see geb in results'
            resultTitles
            resultTitles*.text().collect {
                it ==~ /(?i).*geb.*/
            }.every()
    }

}
