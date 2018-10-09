import geb.*

class GooglePage extends Page {
    static at = {
        title == 'Google'
    }

    static url = 'https://www.google.com/'

    static content = {
        form { $('form#tsf') }
        submit { form.find(type: 'submit', name: 'btnK', 1) }
    }
}
