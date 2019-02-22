package br.com.bicmsystems.demorx

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        // Exemplo 1
        val clubesObservable = Observable.just("Palmeiras", "SFC", "SPFC", "SCCP")
        clubesObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter { it.toUpperCase().startsWith("P") }
                .subscribe(getClubesObserver())
        */

        /*
        // Exemplo 2
        Observable.range(1, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter { it % 2 == 0 }
                .map { "$it é par" }
                .subscribe(object :  DisposableObserver<String>() {

                    override fun onComplete() {
                        Log.d("TAG", "Todos os itens emitidos")
                    }

                    override fun onNext(t: String) {
                        Log.d("TAG", t)
                    }

                    override fun onError(e: Throwable) {
                        Log.e("TAG", "Erro: " + e.message)
                    }

                })
        */

        // Exemplo 3
        Observable.range(1, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { if(it % 2 == 0) "$it é par"  else  "$it é ímpar" }
                .subscribe(object :  DisposableObserver<String>() {

                    override fun onComplete() {
                        Log.d("TAG", "Todos os itens emitidos")
                    }

                    override fun onNext(t: String) {
                        Log.d("TAG", t)
                    }

                    override fun onError(e: Throwable) {
                        Log.e("TAG", "Erro: " + e.message)
                    }

                })
    }

    /*
    // Continuação do Exemplo 1
    private fun getClubesObserver(): Observer<String> {

        return object : Observer<String> {

            override fun onComplete() {
                Log.d("TAG", "Todos os itens emitidos")
            }

            override fun onSubscribe(d: Disposable) {
                Log.d("TAG", "onSubscribe")
            }

            override fun onNext(clube: String) {
                Log.d("TAG", "Nome: $clube")
            }

            override fun onError(e: Throwable) {
                Log.e("TAG", "Erro: " + e.message)
            }

        }

    }
    */

}
