package suites;

import org.junit.platform.suite.api.*;

import modulo1.integracao.*;

@Suite
@SuiteDisplayName("Suite Testes Classes")
@SelectClasses({
        IntegracaoTeste01.class,
})

public class SuiteTestsClasses {

}

