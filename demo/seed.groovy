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
	//  clean up workspace prior to execution
        preBuildCleanup()
    }

    triggers {
        cron('0 7 * * *')
    }

    steps {
        dsl {
            external('demo/freestyle/*/*.groovy')
            removeAction('DELETE')
            removeViewAction('DELETE')
        }
    }
}

folder('demo') {
    displayName('demo')
}
folder('demo/freestyle') {
    displayName('freestyle')
}
folder('demo/pipeline') {
    displayName('pipeline')
}



pipelineJob('demo/seed') {
    definition {
        myScm {
            scm {
                git {
                    branch('*/master')
                    remote {
                        url('https://github.com/chandraprakashdwivedi/DSL-Jobs.git')
                        credentials('my-pat-token-cred')
                    }
                    extensions {
                        wipeOutWorkspace()
                    }
                }
                scriptPath('demo/pipeline/jenkins/*/*.groovy')
            }
        }
    }
}
