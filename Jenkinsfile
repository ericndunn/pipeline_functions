pipeline {
    agent {
        label 'windows'
  }
    stages {
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Environment variables') {
            steps {
                bat('set')
            }
        }
        stage('Version of PS') {
            steps {
                powershell label: '', script: '$PSVersionTable'
            }
        }
        stage('Get-ChildItem') {
            steps {
                powershell label: '', script: '''Get-ChildItem |
                Sort-Object -Property LastWriteTime, Name |
                Format-Table -Property LastWriteTime, Name'''
            }
        }
        stage('Get-CimInstance') {
            steps {
                powershell label: '', script: '''Get-CimInstance -ClassName Win32_QuickFixEngineering -ComputerName . -Property HotFixID'''
            }
        }
        stage('Test on Linux at end of Jenkinsfile') {
            agent {
                label 'windows'
            }
            steps {
                echo 'Hallow Linux END...'
            }
        }
    }
}

