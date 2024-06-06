package com.in28minutes.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {
	//BusinessCalculationServiceクラスのインスタンスがDataService型のオブジェクトを保存する。
	private DataService dataService;

	// コンストラクタ
	/*このコンストラクタは、
	BusinessCalculationServiceクラスの新しいインスタンスを作成するときに呼び出され、
	DataService型のオブジェクトを受け取り、
	それをクラス内のフィールドに設定します。
	これにより、クラス内の他のメソッドでdataServiceフィールドを使用してデータサービスにアクセスできるようになります。*/
	public BusinessCalculationService(DataService dataService) {
		super(); // スーパークラスのコンストラクタ呼び出し
		/*コンストラクタの引数のdataServiceが、クラスのインスタンスフィールド(this)dataServiceに代入される。
		これにより、フィールドの初期化をする
		this.～によって、引数とフィールドが同名でも区別できる。
		*/
		this.dataService = dataService;
	}

	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}

}
