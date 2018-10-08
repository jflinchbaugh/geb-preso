import geb.*

class GooglePage extends Page {
    static url = 'https://www.google.com/'

    static at = {
        title == 'Google'
    }

    static content = {
        form { $('form') }
        submit {
            $('form input', name: 'btnK', 0)
        }
    }
}
