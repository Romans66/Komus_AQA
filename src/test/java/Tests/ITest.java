package Tests;

import Const.PagesURLConst;

public interface ITest extends PagesURLConst {
  void BeforeStart();
  void Start();
  void AfterTest() throws InterruptedException;
}


