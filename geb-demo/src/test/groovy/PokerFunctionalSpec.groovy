import geb.spock.*
import geb.*
import spock.lang.*

class PokerFunctionalSpec extends GebReportingSpec {
    private static url = "file:///Users/jflinchbaugh/my/poker-jquery-slow/index.html"
    void "shows cards"() {
        given: "go to our poker app"
            go url
        expect: "all is well"
            $('.card')*.text() == [0, 1, 2, 3, 5, 8, 13, 20, 40, 100]*.toString()
    }

    @Unroll
    void "click the #estimate card shows it big"() {
        given: "go to our poker app"
            go url
        when: 'click the card'
            $('.card', text: estimate).click()
        then: 'all the cards disappeared'
            waitFor { ! $('.card') }
        and: 'it shows the card big'
            waitFor { $('.show').text() } == estimate
        where:
            estimate << [
                1, 2, 100
            ]*.toString()
    }
}
