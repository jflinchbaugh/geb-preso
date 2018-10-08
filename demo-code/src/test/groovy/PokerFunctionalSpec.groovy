import geb.spock.*
import geb.*
import spock.lang.*

class PokerFunctionalSpec extends GebReportingSpec {
    def url = 'file:///Users/jflinchbaugh/my/poker-jquery-slow/index.html'

    void cleanup() {
        sleep 2000
    }

    @Ignore
    void 'it shows all the cards'() {
        given: 'we go to the poker app'
            go url
        expect: 'we see a pile of cards'
            $('.card')*.text() == [
                1,
                2,
                4,
                8,
                16,
                32,
                64,
                128
            ]*.toString()
    }

    @Unroll
    void 'clicking the #estimate card shows it big'() {
        given: 'we go to the poker app'
            go url
        when: 'we click the card'
            $('.card', text: estimate).click()
        then: 'see the big card'
            waitFor { $('.show').text() } == estimate
        where:
            estimate << [ 1, 2, 3 ]*.toString()
    }
}
