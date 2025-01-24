classDiagram
direction BT
class BakingStrategy {
  + BakingStrategy() 
  + cook(Ingredient) Ingredient
}
class BoilingStrategy {
  + BoilingStrategy() 
  + cook(Ingredient) Ingredient
}
class Chef {
  + Chef() 
  + prepareShawarma() void
  + addCommand(Command) void
}
class Chef {
  + Chef() 
  + addCommand(Command) void
  + prepareShawarma(KitchenFacade) void
}
class Client {
  + Client() 
  + update(String) void
}
class Colleague {
  + Colleague() 
}
class Colleague {
  + Colleague() 
  # Mediator mediator
   Mediator mediator
}
class Command {
<<Interface>>
  + execute() void
}
class Container {
  + Container() 
  - Shawarma shawarma
  + hashCode() int
  # canEqual(Object) boolean
  + equals(Object) boolean
  + toString() String
   Shawarma shawarma
}
class CookIngredientCommand {
  + CookIngredientCommand(CookingDevice, RecipeIngredient) 
  + execute() void
}
class CookingDevice {
<<Interface>>
  + cook(Ingredient) Ingredient
}
class CookingOrderMiddleware {
  + CookingOrderMiddleware(Chef, KitchenFacade) 
  # canHandle(Order) boolean
  # process(Order) void
}
class CookingStrategy {
<<Interface>>
  + cook(Ingredient) Ingredient
}
class CostCalculatorOrderVisitor {
  + CostCalculatorOrderVisitor(Menu) 
  + visit(OrderPosition) Double
  + visit(MenuDish) Double
  + visit(Order) Double
  + visit(MenuIngredient) Double
}
class DeviceFactory {
  + DeviceFactory() 
  + getFreeDevice(Class~T~) T
}
class Dish {
  + Dish(String) 
  - String name
   String name
}
class FryingStrategy {
  + FryingStrategy() 
  + cook(Ingredient) Ingredient
}
class Grill {
  + Grill(String) 
  - String name
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
  + cook(Ingredient) Ingredient
   String name
}
class Ingredient {
  + Ingredient(String) 
  - String name
  + toString() String
   String name
}
class Ingredient {
  + Ingredient(String) 
  - String name
   String name
}
class IngredientFactory {
  + IngredientFactory() 
  + getByRecipe(RecipeIngredient) Ingredient
  - canBeCooked(String) boolean
}
class KitchenFacade {
  + KitchenFacade() 
  + takeIngredient(RecipeIngredient) Ingredient
  - cookIfNeeded(Ingredient, RecipeIngredient) Ingredient
}
class KitchenMediator {
  + KitchenMediator(KitchenFacade, Chef, Packer) 
  + cookOrder(Order) void
}
class Mediator {
<<Interface>>
  + cookOrder(Order) void
  + packageShawarma() void
  + packageOrder() void
}
class Mediator {
<<Interface>>
  + cookOrder(Order) void
}
class Menu {
  + Menu(Map~MenuDish, Double~, Map~MenuIngredient, Double~) 
  - Map~MenuIngredient, Double~ ingredients
  - Map~MenuDish, Double~ dishes
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
   Map~MenuIngredient, Double~ ingredients
   Map~MenuDish, Double~ dishes
}
class MenuDish {
  + MenuDish(String, List~MenuIngredient~) 
  + MenuDish() 
  - String name
  - List~MenuIngredient~ composition
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
   String name
   List~MenuIngredient~ composition
}
class MenuIngredient {
  + MenuIngredient(String) 
  - String name
  + toString() String
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
   String name
}
class MenuPrinter {
  + MenuPrinter() 
  + printIngredientPrices(Menu) void
  + printDishesPrices(Menu) void
  + print(Menu) void
}
class Middleware {
  + Middleware() 
  - Middleware next
  + handle(Order) void
  # process(Order) void
  # canHandle(Order) boolean
   Middleware next
}
class NewOrderMiddleware {
  + NewOrderMiddleware() 
  # canHandle(Order) boolean
  # process(Order) void
}
class Observer {
<<Interface>>
  + update(String) void
}
class Order {
  + Order(List~OrderPosition~) 
  - List~OrderPosition~ positions
  - List~Observer~ observers
  - String status
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
  + addObserver(Observer) void
  - notifyObservers() void
   List~OrderPosition~ positions
   String status
   List~Observer~ observers
}
class OrderBuilder {
  + OrderBuilder() 
  + addPosition(OrderPosition) OrderBuilder
  + removePosition(int) OrderBuilder
  + build() Order
}
class OrderManager {
  + OrderManager(Menu) 
  + makeTestOrderFor(Observer) Order
  - findDishByName(String) MenuDish
  + makeTestOrder() Order
  - findIngredientByName(String) MenuIngredient
}
class OrderPosition {
  + OrderPosition(MenuDish, Integer, Map~MenuIngredient, Integer~, List~MenuIngredient~) 
  - MenuDish dish
  - Integer quantity
  - Map~MenuIngredient, Integer~ additionalIngredients
  - List~MenuIngredient~ excludedIngredients
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
   List~MenuIngredient~ excludedIngredients
   Integer quantity
   Map~MenuIngredient, Integer~ additionalIngredients
   MenuDish dish
}
class OrderPosition {
  + OrderPosition() 
  - Integer quantity
  - Map~MenuIngredient, Integer~ additionalIngredients
  - MenuDish dish
  - List~MenuIngredient~ excludedIngredients
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
  + equals(Object) boolean
   List~MenuIngredient~ excludedIngredients
   Integer quantity
   Map~MenuIngredient, Integer~ additionalIngredients
   MenuDish dish
}
class OrderPositionBuilder {
  + OrderPositionBuilder(MenuDish) 
  + addIngredient(MenuIngredient, Integer) OrderPositionBuilder
  + plus() OrderPositionBuilder
  + minus() OrderPositionBuilder
  + addIngredient(MenuIngredient) OrderPositionBuilder
  + minus(Integer) OrderPositionBuilder
  + plus(Integer) OrderPositionBuilder
  + excludeIngredient(MenuIngredient) OrderPositionBuilder
  + build() OrderPosition
}
class OrderPrinter {
  + OrderPrinter(CostCalculatorOrderVisitor) 
  + OrderPrinter(Menu) 
  + stringifyPosition(OrderPosition) String
  + print(Order) void
}
class OrderVisitor~T~ {
<<Interface>>
  + visit(OrderPosition) T
  + visit(Order) T
  + visit(MenuIngredient) T
  + visit(MenuDish) T
}
class Oven {
  + Oven(String) 
  - String name
  # canEqual(Object) boolean
  + toString() String
  + cook(RecipeIngredient) Ingredient
  + hashCode() int
  + equals(Object) boolean
   String name
}
class Oven {
  + Oven(String) 
  - String name
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
  + cook(Ingredient) Ingredient
   String name
}
class PackShawarmaCommand {
  + PackShawarmaCommand() 
  + execute(KitchenFacade) void
}
class Packer {
  + Packer() 
  + pack(Order) void
}
class Pan {
  + Pan(String) 
  - String name
  # canEqual(Object) boolean
  + equals(Object) boolean
  + cook(RecipeIngredient) Ingredient
  + hashCode() int
  + toString() String
   String name
}
class Pan {
  + Pan(String) 
  - String name
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
  + cook(Ingredient) Ingredient
   String name
}
class Pot {
  + Pot(String) 
  - String name
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
  + cook(Ingredient) Ingredient
   String name
}
class PriceCalculator {
  + PriceCalculator(Menu) 
  + visit(OrderPosition) double
}
class ReadyOrderMiddleware {
  + ReadyOrderMiddleware(Packer) 
  # canHandle(Order) boolean
  # process(Order) void
}
class RecipeFormer {
  + RecipeFormer() 
  + recipeOf(OrderPosition) Recipe
  - stepFor(RecipeIngredient) RecipeStep
  + recipesOf(Order) Map~OrderPosition, Recipe~
}
class RecipeIngredient {
  + RecipeIngredient(String, Integer) 
  - String name
  - Integer gram
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
   String name
   Integer gram
}
class RecipeStep {
  + RecipeStep(Command) 
  - Command command
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
   Command command
}
class Shawarma {
  + Shawarma() 
  + Shawarma(String, List~Ingredient~) 
  - List~Ingredient~ ingredients
  - String name
  + toString() String
  + hashCode() int
  + equals(Object) boolean
  # canEqual(Object) boolean
  + addIngredient(Ingredient) void
  + wrap() void
   String name
   List~Ingredient~ ingredients
}
class ShawarmaCookingControlSystem {
  + ShawarmaCookingControlSystem() 
  + main(String[]) void
}
class ShawarmaMediator {
  + ShawarmaMediator(DeviceFactory, Chef) 
  + ShawarmaMediator() 
  + cookOrder(Order) void
  + packageOrder() void
  + packageShawarma() void
}
class TakeIngredientCommand {
  + TakeIngredientCommand(RecipeIngredient) 
  + execute(KitchenFacade) void
}
class Technologist {
  + Technologist() 
  + createMenu() Menu
}
class Visitor {
<<Interface>>
  + visit(OrderPosition) double
}

BakingStrategy  ..>  CookingStrategy 
BoilingStrategy  ..>  CookingStrategy 
Chef  -->  Colleague 
Chef "1" *--> "commands *" Command 
Chef "1" *--> "commands *" Command 
Client  ..>  Observer 
Colleague "1" *--> "mediator 1" Mediator 
Container "1" *--> "shawarma 1" Shawarma 
CookIngredientCommand  ..>  Command 
CookingOrderMiddleware "1" *--> "chef 1" Chef 
CookingOrderMiddleware "1" *--> "kitchenFacade 1" KitchenFacade 
CookingOrderMiddleware  -->  Middleware 
CookingOrderMiddleware  ..>  PackShawarmaCommand : «create»
CostCalculatorOrderVisitor "1" *--> "menu 1" Menu 
CostCalculatorOrderVisitor  ..>  OrderVisitor~T~ 
DeviceFactory  ..>  Grill : «create»
DeviceFactory  ..>  Oven : «create»
DeviceFactory  ..>  Pan : «create»
DeviceFactory  ..>  Pot : «create»
FryingStrategy  ..>  CookingStrategy 
Grill  ..>  CookingDevice 
Grill  ..>  Ingredient : «create»
IngredientFactory  ..>  Ingredient : «create»
KitchenFacade  ..>  BakingStrategy : «create»
KitchenFacade  ..>  BoilingStrategy : «create»
KitchenFacade "1" *--> "cookingStrategies *" CookingStrategy 
KitchenFacade  ..>  FryingStrategy : «create»
KitchenMediator "1" *--> "chef 1" Chef 
KitchenMediator  ..>  CookingOrderMiddleware : «create»
KitchenMediator "1" *--> "kitchenFacade 1" KitchenFacade 
KitchenMediator  ..>  Mediator 
KitchenMediator  ..>  NewOrderMiddleware : «create»
KitchenMediator "1" *--> "packer 1" Packer 
KitchenMediator  ..>  ReadyOrderMiddleware : «create»
Menu "1" *--> "dishes *" MenuDish 
Menu "1" *--> "ingredients *" MenuIngredient 
MenuDish "1" *--> "composition *" MenuIngredient 
NewOrderMiddleware  -->  Middleware 
Order "1" *--> "observers *" Observer 
Order "1" *--> "positions *" OrderPosition 
OrderBuilder  ..>  Order : «create»
OrderBuilder "1" *--> "positions *" OrderPosition 
OrderManager "1" *--> "menu 1" Menu 
OrderManager  ..>  OrderBuilder : «create»
OrderManager  ..>  OrderPositionBuilder : «create»
OrderPosition "1" *--> "dish 1" MenuDish 
OrderPosition "1" *--> "additionalIngredients *" MenuIngredient 
OrderPositionBuilder "1" *--> "menuDish 1" MenuDish 
OrderPositionBuilder "1" *--> "additionalIngredients *" MenuIngredient 
OrderPositionBuilder  ..>  OrderPosition : «create»
OrderPrinter  ..>  CostCalculatorOrderVisitor : «create»
OrderPrinter "1" *--> "costCalculator 1" CostCalculatorOrderVisitor 
Oven  ..>  CookingDevice 
Oven  ..>  Ingredient : «create»
PackShawarmaCommand  ..>  Command 
Packer  -->  Colleague 
Pan  ..>  CookingDevice 
Pan  ..>  Ingredient : «create»
Pot  ..>  CookingDevice 
Pot  ..>  Ingredient : «create»
ReadyOrderMiddleware  -->  Middleware 
ReadyOrderMiddleware "1" *--> "packer 1" Packer 
RecipeStep "1" *--> "command 1" Command 
TakeIngredientCommand  ..>  Command 
TakeIngredientCommand "1" *--> "recipeIngredient 1" RecipeIngredient 
