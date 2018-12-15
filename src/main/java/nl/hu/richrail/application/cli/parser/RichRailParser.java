//package nl.hu.richrail.application.cli.parser;
//
//import nl.hu.richrail.domain.rollingcomponent.type.Wagon;
//import nl.hu.richrail.services.TrainService;
//import parser.RichRailBaseListener;
//
//public class RichRailParser extends RichRailBaseListener {
//    private TrainService trainService = TrainService.getInstance();
//
//    @Override
//    public void enterCommandNewTrain(parser.RichRailParser.CommandNewTrainContext ctx) {
//        trainService.createTrain(ctx.ID().getText());
//    }
//
//    @Override
//    public void enterCommandNewLocomotive(parser.RichRailParser.CommandNewLocomotiveContext ctx) {
//        trainService.createRollingComponentLocomotive(ctx.ID().getText());
//    }
//
//    @Override
//    public void enterCommandNewWagon(parser.RichRailParser.CommandNewWagonContext ctx) {
//        int numSeats = 0;
//
//        if (ctx.NUMBER() != null) {
//            numSeats = Integer.valueOf(ctx.NUMBER().getText());
//        }
//
//        trainService.createRollingComponentWagon(ctx.ID().getText(), numSeats);
//    }
//
//    @Override
//    public void enterCommandAdd(parser.RichRailParser.CommandAddContext ctx) {
//        trainService.addRollingComponentToTrain(ctx.ID(1).getText(), trainService.getRollingComponent(ctx.ID(0).getText()));
//    }
//
//    @Override
//    public void enterCommandGet(parser.RichRailParser.CommandGetContext ctx) {
//        int result;
//
//        switch (ctx.type().getText()) {
//            case "train": result = trainService.getTotalNumSeats(ctx.ID().getText()); break;
//            case "wagon": result = ((Wagon) trainService.getRollingComponent(ctx.ID().getText())).getSeats(); break;
//            default: result = 0; break;
//        }
//    }
//
//    @Override
//    public void enterCommandDel(parser.RichRailParser.CommandDelContext ctx) {
//        boolean result;
//
//        switch (ctx.type().getText()) {
//            case "train": result = trainService.removeTrain(ctx.ID().getText()); break;
//            case "wagon": result = trainService.removeRollingComponent(ctx.ID().getText()); break;
//            default: result = false; break;
//        }
//    }
//
//    @Override
//    public void enterCommandRem(parser.RichRailParser.CommandRemContext ctx) {
//        trainService.removeRollingComponentFromTrain(ctx.ID(1).getText(), trainService.getRollingComponentFromTrain(ctx.ID(1).getText(), ctx.ID(0).getText()));
//    }
//}
