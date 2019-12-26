// vars/buildPlugin.groovy
def call(Map config) {
    node {
        git url: "https://github.com/ericndunn/${config.name}.git"
        // sh 'mvn clean install'
        // mail to: '...', subject: "${config.name} plugin build", body: '...'
    }
}