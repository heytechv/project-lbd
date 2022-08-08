package com.lbd.projectlbd.service;

import com.lbd.projectlbd.entity.Checkpoint;
import com.lbd.projectlbd.entity.Delegation;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

@Service
public class DelegationServiceImpl implements DelegationService {

    @Override public void add(Delegation delegation) {
        //Wykorzystanie warunków SpEL do dodawania checkpointów do delegacji
//        ExpressionParser parser = new SpelExpressionParser();
//        EvaluationContext context = new StandardEvaluationContext(delegation);
//        for(Checkpoint checkpoint : checkpointService.getAllCheckpoints()) {
//            if(parser.parseExpression(checkpoint.getSpelExpression()).getValue(context, Boolean.class)) {
//                ////kopiowanie tego checkpointa do listy checkpointów delegacji
//            }
//        }
    }

    @Override
    public void delete() {

    }
}
