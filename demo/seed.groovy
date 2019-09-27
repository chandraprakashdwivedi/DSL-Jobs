freeStyleJob("demo/seed") {
    label 'master'
    logRotator(numToKeep = 10)
    scm {
        git {
            remote {
                url("https://github.com/chandraprakashdwivedi/DSL-Jobs.git")
                credentials('my-pat-token-cred')   //Issue a PAT token in your git repo and save that in your jenkins 
            }
            branch('master')
        }
    }
    wrappers {
        preBuildCleanup()
    }

    triggers {
        cron('0 7 * * *')
    }

    steps {
        dsl {
            external('demo/*/*.groovy')
            removeAction('DELETE')
            removeViewAction('DELETE')
        }
    }
}

folder('demo') {
    displayName('demo')
}
folder('demo/job1') {
    displayName('job1')
}

