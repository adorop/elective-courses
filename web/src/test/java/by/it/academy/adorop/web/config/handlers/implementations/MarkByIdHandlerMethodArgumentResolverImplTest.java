package by.it.academy.adorop.web.config.handlers.implementations;

import by.it.academy.adorop.service.api.MarkService;
import by.it.academy.adorop.service.api.Service;
import org.mockito.Mock;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import static org.mockito.Mockito.verify;

public class MarkByIdHandlerMethodArgumentResolverImplTest extends AbstractByIdHandlerMethodArgumentResolverImplTest {

    @Mock
    private MarkService markService;

    @Override
    protected Service getService() {
        return markService;
    }

    @Override
    protected HandlerMethodArgumentResolver getResolver() {
        return new MarkByIdHandlerMethodArgumentResolverImpl(markService);
    }
}